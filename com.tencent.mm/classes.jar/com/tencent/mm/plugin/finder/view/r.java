package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.model.cgi.n;
import com.tencent.mm.plugin.finder.live.model.cgi.n.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/LiveLogoAssistant;", "", "context", "Landroid/content/Context;", "anchorUsername", "", "position", "", "isLiveFeed", "", "(Landroid/content/Context;Ljava/lang/String;IZ)V", "getAnchorUsername", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "()Z", "getPosition", "()I", "gotoLive", "", "reportOnClick", "pageName", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public final class r
{
  final Context context;
  final String hwd;
  final int position;
  final boolean wqB;
  
  public r(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(255073);
    this.context = paramContext;
    this.hwd = paramString;
    this.position = paramInt;
    this.wqB = paramBoolean;
    AppMethodBeat.o(255073);
  }
  
  public final void dzC()
  {
    AppMethodBeat.i(255072);
    Object localObject = (CharSequence)this.hwd;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label78;
      }
      localObject = this.hwd;
      if (localObject != null) {
        break label96;
      }
      localObject = "";
    }
    label78:
    label96:
    for (;;)
    {
      new n((String)localObject, (n.a)new a(this)).aYI();
      AppMethodBeat.o(255072);
      return;
      i = 0;
      break;
      localObject = FinderLiveOnliveWidget.wnW;
      Log.i(FinderLiveOnliveWidget.access$getTAG$cp(), "[LiveLogoAssistant]click live icon but username is empty!");
      AppMethodBeat.o(255072);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/LiveLogoAssistant$gotoLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder_release"})
  public static final class a
    implements n.a
  {
    public final void a(asm paramasm)
    {
      Object localObject1 = null;
      AppMethodBeat.i(255071);
      p.h(paramasm, "resp");
      Object localObject2 = paramasm.LCD;
      if (localObject2 != null)
      {
        paramasm = ((FinderObject)localObject2).contact;
        if (paramasm != null) {}
        for (paramasm = paramasm.username; p.j(paramasm, this.wqC.hwd); paramasm = null)
        {
          d.h((a)new a(this, (FinderObject)localObject2));
          AppMethodBeat.o(255071);
          return;
        }
      }
      paramasm = FinderLiveOnliveWidget.wnW;
      String str = FinderLiveOnliveWidget.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("[LiveLogoAssistant]CgiFinderLiveGetLastObject invalid resp local username:").append(this.wqC.hwd).append(",remote username:");
      paramasm = localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((FinderObject)localObject2).contact;
        paramasm = localObject1;
        if (localObject2 != null) {
          paramasm = ((FinderContact)localObject2).username;
        }
      }
      Log.i(str, paramasm);
      AppMethodBeat.o(255071);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(r.a parama, FinderObject paramFinderObject)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.r
 * JD-Core Version:    0.7.0.1
 */