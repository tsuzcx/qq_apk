package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.d;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.am.a;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1$callback$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class i$a$a
  implements com.tencent.mm.ak.g
{
  i$a$a(List paramList, i.a parama, d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167786);
    com.tencent.mm.kernel.g.agi().b(3870, (com.tencent.mm.ak.g)this);
    ac.i(this.rNv.rNt.TAG, "errType " + paramInt1 + " , errCode " + paramInt2 + ", errMsg " + paramString);
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
      AppMethodBeat.o(167786);
      throw paramString;
    }
    paramString = ((am)paramn).csH();
    paramn = ((am)paramn).csG();
    if ((paramInt1 == 0) && (paramInt2 == 0) && (k.g(this.rNu, paramn)))
    {
      paramString = paramString.iterator();
      paramInt1 = 0;
      if (paramString.hasNext())
      {
        paramn = (aiz)paramString.next();
        paramInt2 = paramn.cmdId;
        am.a locala = am.qYu;
        if ((paramInt2 == am.csI()) && (paramn.retCode == 0))
        {
          paramInt2 = 1;
          label183:
          if (paramInt2 == 0) {
            break label262;
          }
        }
      }
      for (;;)
      {
        if (paramInt1 == -1) {
          break label274;
        }
        ac.i(this.rNv.rNt.TAG, "update coverImg succ");
        paramString = this.rNv.rNt;
        paramn = this.ruh.field_fileUrl;
        k.g(paramn, "sceneResult.field_fileUrl");
        i.a(paramString, paramn, true);
        this.rNv.rNt.a(h.gLN);
        AppMethodBeat.o(167786);
        return;
        paramInt2 = 0;
        break label183;
        label262:
        paramInt1 += 1;
        break;
        paramInt1 = -1;
      }
      label274:
      ac.i(this.rNv.rNt.TAG, "update coverImg failed");
      paramString = this.rNv.rNt;
      paramn = this.ruh.field_fileUrl;
      k.g(paramn, "sceneResult.field_fileUrl");
      i.a(paramString, paramn, false);
      this.rNv.rNt.a(h.gLO);
    }
    AppMethodBeat.o(167786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.i.a.a
 * JD-Core Version:    0.7.0.1
 */