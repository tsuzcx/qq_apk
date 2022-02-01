package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.h;
import com.tencent.mm.ay.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.aa;
import java.util.HashSet;
import java.util.Set;

public final class j
  extends b
{
  private final int tlc;
  private Set<ImageView> tlr;
  private View.OnClickListener tls;
  
  public j(com.tencent.mm.plugin.fav.ui.o paramo)
  {
    super(paramo);
    AppMethodBeat.i(235380);
    this.tls = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235379);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (!e.apn())
        {
          u.g(j.this.tdg.context, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235379);
          return;
        }
        anh localanh;
        aml localaml;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g))
        {
          localObject = (com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag();
          localanh = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.Lya;
          localaml = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject);
          if (localaml == null)
          {
            Log.w("MicroMsg.FavBaseListItem", "data item is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235379);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localaml))
          {
            Log.i("MicroMsg.FavBaseListItem", "same song, do release");
            com.tencent.mm.ay.a.bea();
            j.a(j.this, null);
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235379);
          return;
        }
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235379);
          return;
        }
        localObject = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.a(localaml));
        if (!((com.tencent.mm.vfs.o)localObject).exists()) {
          if (localaml.dFN == null)
          {
            localObject = "";
            label241:
            if (localaml.Lwh == null) {
              break label433;
            }
          }
        }
        label433:
        for (css localcss = localaml.Lwh.Lxs;; localcss = null)
        {
          localObject = i.a(6, null, localaml.title, localaml.desc, localaml.Lvu, localaml.Lvy, localaml.Lvw, localaml.dLl, com.tencent.mm.plugin.fav.a.b.cUl(), (String)localObject, "", localanh.appId, h.a(localaml.dLl, localcss));
          ((f)localObject).jfm = localaml.songAlbumUrl;
          ((f)localObject).jfe = localaml.songLyric;
          ((f)localObject).jfw = localaml.dLl;
          com.tencent.mm.ay.a.c((f)localObject);
          j.a(j.this, (ImageView)paramAnonymousView);
          break;
          localObject = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(localaml.dFN.getBytes()));
          if (((com.tencent.mm.vfs.o)localObject).exists()) {}
          for (localObject = aa.z(((com.tencent.mm.vfs.o)localObject).her());; localObject = "") {
            break;
          }
          localObject = aa.z(((com.tencent.mm.vfs.o)localObject).her());
          break label241;
        }
      }
    };
    this.tlc = com.tencent.mm.cb.a.aG(paramo.context, 2131165369);
    this.tlr = new HashSet();
    AppMethodBeat.o(235380);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    css localcss = null;
    AppMethodBeat.i(235381);
    Context localContext = paramViewGroup.getContext();
    a locala;
    View localView1;
    if (paramView == null)
    {
      locala = new a();
      localView1 = a(View.inflate(localContext, 2131494124, null), locala, paramg);
      locala.nnL = ((ImageView)localView1.findViewById(2131300468));
      locala.jVO = ((TextView)localView1.findViewById(2131300526));
      locala.jBR = ((TextView)localView1.findViewById(2131300451));
      locala.tlu = ((ImageView)localView1.findViewById(2131300473));
      locala.tln = ((TextView)localView1.findViewById(2131300503));
      locala.tln.setVisibility(8);
      locala.tlu.setOnClickListener(this.tls);
      locala.tlu.setVisibility(0);
      this.tlr.add(locala.tlu);
    }
    aml localaml;
    for (;;)
    {
      a(locala, paramg);
      localaml = com.tencent.mm.plugin.fav.a.b.c(paramg);
      if (localaml == null)
      {
        Log.w("MicroMsg.FavBaseListItem", "getView, data item is null");
        AppMethodBeat.o(235381);
        return localView1;
        try
        {
          locala = (a)paramView.getTag();
          localView1 = paramView;
        }
        catch (Exception paramViewGroup)
        {
          Log.e("MicroMsg.FavBaseListItem", "invalid type, message:" + paramViewGroup.getMessage());
          AppMethodBeat.o(235381);
          return paramView;
        }
      }
    }
    String str1 = localaml.title;
    paramView = localaml.desc;
    String str2 = "";
    if (localaml.Lwh != null) {
      localcss = localaml.Lwh.Lxs;
    }
    View localView2 = paramView;
    paramViewGroup = str1;
    if (localcss != null)
    {
      if (!Util.isNullOrNil(localcss.Ktq))
      {
        paramView = localcss.Ktq + localContext.getString(2131763368);
        paramViewGroup = str1 + String.format("·%s", new Object[] { localaml.desc });
        str2 = localcss.Ktp;
        localView2 = paramView;
      }
    }
    else
    {
      locala.jVO.setText(paramViewGroup);
      if (!Util.isNullOrNil(localView2))
      {
        locala.jBR.setText(localView2);
        locala.jBR.setVisibility(0);
      }
      if (localaml.Lwh == null) {
        localaml.a(new amm());
      }
      if (localaml.Lwh.Lxs == null) {
        localaml.Lwh.e(new css());
      }
      if (Util.isNullOrNil(str2)) {
        break label611;
      }
      paramViewGroup = new c.a();
      paramView = com.tencent.mm.plugin.music.h.b.aIf(str2);
      paramViewGroup.fullPath = paramView;
      paramViewGroup.jbf = true;
      paramViewGroup.iaT = true;
      paramViewGroup.jbd = true;
      paramViewGroup.hZF = true;
      paramViewGroup.jbx = com.tencent.mm.cb.a.fromDPToPix(localContext, 2);
      paramViewGroup = paramViewGroup.bdv();
      q.bcV().a(str2, locala.nnL, paramViewGroup);
      localaml.Lwh.Lxs.jfz = paramView;
      label550:
      locala.tlu.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f(localaml)) {
        break label640;
      }
      locala.tlu.setImageResource(2131234170);
    }
    for (;;)
    {
      AppMethodBeat.o(235381);
      return localView1;
      paramViewGroup = str1;
      if (Util.isNullOrNil(localcss.singerName)) {
        break;
      }
      paramView = localcss.singerName;
      paramViewGroup = str1;
      break;
      label611:
      this.tdg.a(locala.nnL, localaml, paramg, 2131689567, this.tlc, this.tlc);
      break label550;
      label640:
      locala.tlu.setImageResource(2131234185);
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(235382);
    if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(235382);
      return;
    }
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(235382);
  }
  
  public static final class a
    extends b.b
  {
    TextView jBR;
    TextView jVO;
    ImageView nnL;
    TextView tln;
    ImageView tlu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.j
 * JD-Core Version:    0.7.0.1
 */