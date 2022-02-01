package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Set;

public final class i
  extends b
{
  private final int qTc;
  private Set<ImageView> qTr;
  private View.OnClickListener qTs;
  
  public i(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107465);
    this.qTs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107464);
        if (!com.tencent.mm.compatible.util.e.YD())
        {
          t.g(i.this.qLn.context, null);
          AppMethodBeat.o(107464);
          return;
        }
        Object localObject;
        aht localaht;
        agx localagx;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g))
        {
          localObject = (com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag();
          localaht = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.EBJ;
          localagx = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject);
          if (localagx == null)
          {
            ac.w("MicroMsg.FavBaseListItem", "data item is null");
            AppMethodBeat.o(107464);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localagx))
          {
            ac.i("MicroMsg.FavBaseListItem", "same song, do release");
            com.tencent.mm.ay.a.aGt();
            i.a(i.this, null);
            AppMethodBeat.o(107464);
            return;
          }
          localObject = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localagx));
          if (((com.tencent.mm.vfs.e)localObject).exists()) {
            break label301;
          }
          if (localagx.dbZ != null) {
            break label239;
          }
          localObject = "";
        }
        for (;;)
        {
          localObject = com.tencent.mm.ay.g.a(6, null, localagx.title, localagx.desc, localagx.Ezm, localagx.Ezq, localagx.Ezo, localagx.dhw, com.tencent.mm.plugin.fav.a.b.cpc(), (String)localObject, "", localaht.appId);
          ((f)localObject).hOj = localagx.songAlbumUrl;
          ((f)localObject).hOb = localagx.songLyric;
          ((f)localObject).hOt = localagx.dhw;
          com.tencent.mm.ay.a.c((f)localObject);
          i.a(i.this, (ImageView)paramAnonymousView);
          AppMethodBeat.o(107464);
          return;
          label239:
          localObject = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.coW() + com.tencent.mm.b.g.getMessageDigest(localagx.dbZ.getBytes()));
          if (((com.tencent.mm.vfs.e)localObject).exists()) {}
          for (localObject = q.B(((com.tencent.mm.vfs.e)localObject).fxV());; localObject = "") {
            break;
          }
          label301:
          localObject = q.B(((com.tencent.mm.vfs.e)localObject).fxV());
        }
      }
    };
    this.qTc = com.tencent.mm.cc.a.au(paramo.context, 2131165358);
    this.qTr = new HashSet();
    AppMethodBeat.o(107465);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107466);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131493955, null), paramViewGroup, paramg);
      paramViewGroup.lzC = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iCg = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.ijE = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.qTu = ((ImageView)paramView.findViewById(2131299798));
      paramViewGroup.qTn = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.qTn.setVisibility(8);
      paramViewGroup.qTu.setOnClickListener(this.qTs);
      paramViewGroup.qTu.setVisibility(0);
      this.qTr.add(paramViewGroup.qTu);
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup.iCg.setText(((agx)localObject).title);
      paramViewGroup.ijE.setText(((agx)localObject).desc);
      paramViewGroup.ijE.setVisibility(0);
      this.qLn.a(paramViewGroup.lzC, (agx)localObject, paramg, 2131689564, this.qTc, this.qTc);
      paramViewGroup.qTu.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f((agx)localObject)) {
        break label256;
      }
      paramViewGroup.qTu.setImageResource(2131233393);
    }
    for (;;)
    {
      AppMethodBeat.o(107466);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label256:
      paramViewGroup.qTu.setImageResource(2131233395);
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107467);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qJy, paramahp);
    AppMethodBeat.o(107467);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCg;
    TextView ijE;
    ImageView lzC;
    TextView qTn;
    ImageView qTu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.i
 * JD-Core Version:    0.7.0.1
 */