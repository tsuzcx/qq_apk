package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.aa;
import java.util.HashSet;
import java.util.Set;

public final class i
  extends b
{
  private final int tlc;
  private Set<ImageView> tlr;
  private View.OnClickListener tls;
  
  public i(com.tencent.mm.plugin.fav.ui.o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107465);
    this.tls = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107464);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (!e.apn())
        {
          u.g(i.this.tdg.context, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107464);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localaml))
          {
            Log.i("MicroMsg.FavBaseListItem", "same song, do release");
            com.tencent.mm.ay.a.bea();
            i.a(i.this, null);
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        localObject = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.a(localaml));
        if (!((com.tencent.mm.vfs.o)localObject).exists()) {
          if (localaml.dFN == null) {
            localObject = "";
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.ay.i.a(6, null, localaml.title, localaml.desc, localaml.Lvu, localaml.Lvy, localaml.Lvw, localaml.dLl, com.tencent.mm.plugin.fav.a.b.cUl(), (String)localObject, "", localanh.appId);
          ((f)localObject).jfm = localaml.songAlbumUrl;
          ((f)localObject).jfe = localaml.songLyric;
          ((f)localObject).jfw = localaml.dLl;
          com.tencent.mm.ay.a.c((f)localObject);
          i.a(i.this, (ImageView)paramAnonymousView);
          break;
          localObject = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(localaml.dFN.getBytes()));
          if (((com.tencent.mm.vfs.o)localObject).exists()) {}
          for (localObject = aa.z(((com.tencent.mm.vfs.o)localObject).her());; localObject = "") {
            break;
          }
          localObject = aa.z(((com.tencent.mm.vfs.o)localObject).her());
        }
      }
    };
    this.tlc = com.tencent.mm.cb.a.aG(paramo.context, 2131165369);
    this.tlr = new HashSet();
    AppMethodBeat.o(107465);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107466);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131494124, null), paramViewGroup, paramg);
      paramViewGroup.nnL = ((ImageView)paramView.findViewById(2131300468));
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131300526));
      paramViewGroup.jBR = ((TextView)paramView.findViewById(2131300451));
      paramViewGroup.tlu = ((ImageView)paramView.findViewById(2131300473));
      paramViewGroup.tln = ((TextView)paramView.findViewById(2131300503));
      paramViewGroup.tln.setVisibility(8);
      paramViewGroup.tlu.setOnClickListener(this.tls);
      paramViewGroup.tlu.setVisibility(0);
      this.tlr.add(paramViewGroup.tlu);
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup.jVO.setText(((aml)localObject).title);
      paramViewGroup.jBR.setText(((aml)localObject).desc);
      paramViewGroup.jBR.setVisibility(0);
      this.tdg.a(paramViewGroup.nnL, (aml)localObject, paramg, 2131689567, this.tlc, this.tlc);
      paramViewGroup.tlu.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f((aml)localObject)) {
        break label288;
      }
      paramViewGroup.tlu.setImageResource(2131234170);
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(107466);
        return paramView;
        try
        {
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception paramViewGroup)
        {
          Log.e("MicroMsg.FavBaseListItem", "invalid type, message:" + paramViewGroup.getMessage());
          AppMethodBeat.o(107466);
          return paramView;
        }
      }
      label288:
      paramViewGroup.tlu.setImageResource(2131234185);
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107467);
    if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(107467);
      return;
    }
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107467);
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
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.i
 * JD-Core Version:    0.7.0.1
 */