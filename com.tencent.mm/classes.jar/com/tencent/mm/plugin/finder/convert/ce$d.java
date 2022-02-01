package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.b.a.ig;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bi;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.findersdk.a.al;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ce$d
  implements View.OnClickListener
{
  ce$d(bi parambi, String paramString1, bdp parambdp, i parami, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(271318);
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aFi());
    localObject2 = new dbr();
    ((dbr)localObject2).Ruu = d.Fw(this.xoy.feedObject.getFinderObject().id);
    ((dbr)localObject2).Ruv = this.xoy.feedObject.getFinderObject().objectNonceId;
    ((dbr)localObject2).Ruw = this.wXO;
    paramView = this.xoy.feedObject.getFinderObject().contact;
    label149:
    label178:
    label207:
    label236:
    long l;
    label265:
    label294:
    int i;
    label323:
    label352:
    label381:
    bds localbds;
    label410:
    String str;
    if (paramView != null)
    {
      paramView = paramView.nickname;
      ((dbr)localObject2).Rux = paramView;
      paramView = this.xoz;
      if (paramView == null) {
        break label628;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label628;
      }
      paramView = paramView.ozs;
      ((dbr)localObject2).singerName = paramView;
      paramView = this.xoz;
      if (paramView == null) {
        break label633;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label633;
      }
      paramView = paramView.albumName;
      ((dbr)localObject2).albumName = paramView;
      paramView = this.xoz;
      if (paramView == null) {
        break label638;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label638;
      }
      paramView = paramView.extraInfo;
      ((dbr)localObject2).extraInfo = paramView;
      paramView = this.xoz;
      if (paramView == null) {
        break label643;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label643;
      }
      paramView = paramView.SMY;
      ((dbr)localObject2).musicGenre = paramView;
      paramView = this.xoz;
      if (paramView == null) {
        break label648;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label648;
      }
      l = paramView.SOO;
      ((dbr)localObject2).issueDate = l;
      paramView = this.xoz;
      if (paramView == null) {
        break label653;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label653;
      }
      paramView = paramView.ozs;
      ((dbr)localObject2).identification = paramView;
      paramView = this.xoz;
      if (paramView == null) {
        break label658;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label658;
      }
      i = paramView.duration;
      ((dbr)localObject2).FSG = i;
      paramView = this.xoz;
      if (paramView == null) {
        break label663;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label663;
      }
      paramView = paramView.HLH;
      ((dbr)localObject2).HLH = paramView;
      paramView = this.xoz;
      if (paramView == null) {
        break label668;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label668;
      }
      paramView = paramView.SOL;
      ((dbr)localObject2).songLyric = paramView;
      paramView = this.xoz;
      if (paramView == null) {
        break label673;
      }
      paramView = paramView.GaB;
      if (paramView == null) {
        break label673;
      }
      paramView = paramView.SOM;
      ((dbr)localObject2).KGh = paramView;
      ((dbr)localObject2).lVZ = this.wXO;
      paramView = this.xoz;
      if (paramView != null)
      {
        localbds = paramView.GaB;
        if (localbds != null)
        {
          Log.i("Finder.ProfileMusicConvert", "playOrPauseMusic");
          paramView = g.Xox;
          paramView = this.tDl.getContext();
          p.j(paramView, "holder.context");
          ((com.tencent.mm.plugin.finder.profile.uic.h)g.lm(paramView).i(com.tencent.mm.plugin.finder.profile.uic.h.class)).zRm = false;
          ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).ld(false);
          paramView = aa.Amg;
          p.j(localbds, "it");
          str = this.xoA;
          p.k(localbds, "musicSongInfo");
          p.k(str, "musicId");
          f localf = com.tencent.mm.bb.a.bnA();
          paramView = localObject1;
          if (localf != null) {
            paramView = localf.lVt;
          }
          if ((paramView == null) || (!Util.isEqual(localf.lVt, str))) {
            break label690;
          }
          if (!com.tencent.mm.bb.a.bnx()) {
            break label678;
          }
          paramView = new ig();
          paramView.sJ(2L);
          paramView.sK(8L);
          al.a(paramView);
          com.tencent.mm.bb.a.bnv();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271318);
      return;
      paramView = null;
      break;
      label628:
      paramView = null;
      break label149;
      label633:
      paramView = null;
      break label178;
      label638:
      paramView = null;
      break label207;
      label643:
      paramView = null;
      break label236;
      label648:
      l = 0L;
      break label265;
      label653:
      paramView = null;
      break label294;
      label658:
      i = 0;
      break label323;
      label663:
      paramView = null;
      break label352;
      label668:
      paramView = null;
      break label381;
      label673:
      paramView = null;
      break label410;
      label678:
      aa.b(localbds, str, (dbr)localObject2);
      continue;
      label690:
      Log.i("FinderMvLogic", "playMusic");
      aa.b(localbds, str, (dbr)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ce.d
 * JD-Core Version:    0.7.0.1
 */