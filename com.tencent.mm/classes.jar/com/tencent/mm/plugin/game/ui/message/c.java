package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashSet;
import java.util.Set;

public final class c
  extends RecyclerView
{
  private int fwc;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> tsM;
  a tvo;
  private e tvp;
  private Set<Integer> tvq;
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183887);
    this.tvq = new HashSet();
    this.mContext = paramContext;
    this.fwc = paramInt;
    this.tsM = new b(30, getClass());
    this.tvp = new e(this.fwc, new e.b()
    {
      public final void cRC()
      {
        AppMethodBeat.i(183882);
        c.a(c.this).cYG = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gx(2);
        Cursor localCursor = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gv(1);
        c.a(c.this).changeCursor(localCursor);
        AppMethodBeat.o(183882);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gx(1);
    this.tvo = new a(paramContext, ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gv(1), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.tvo);
    AppMethodBeat.o(183887);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183888);
    e.a.a locala = new e.a.a();
    locala.hKv = false;
    locala.twz = paramFloat;
    com.tencent.mm.plugin.game.f.e.cRL().a(paramImageView, paramString, locala.cRM(), new com.tencent.mm.plugin.game.f.e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(183883);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          c.f(c.this).put(paramString, paramAnonymousBitmap);
        }
        AppMethodBeat.o(183883);
      }
    });
    AppMethodBeat.o(183888);
  }
  
  final class a
    extends f<c.b>
  {
    int cYG;
    
    public a(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.cYG = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    ImageView fBA;
    TextView nMU;
    TextView timeTv;
    View tvA;
    ViewGroup tvs;
    TextView tvt;
    TextView tvu;
    ImageView tvv;
    TextView tvw;
    TextView tvx;
    View tvy;
    View tvz;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(183886);
      this.tvs = ((ViewGroup)paramView.findViewById(2131302521));
      this.fBA = ((ImageView)paramView.findViewById(2131300891));
      this.nMU = ((TextView)paramView.findViewById(2131302867));
      this.tvt = ((TextView)paramView.findViewById(2131302485));
      this.tvu = ((TextView)paramView.findViewById(2131304199));
      this.tvv = ((ImageView)paramView.findViewById(2131304189));
      this.tvw = ((TextView)paramView.findViewById(2131298778));
      this.timeTv = ((TextView)paramView.findViewById(2131305822));
      this.tvx = ((TextView)paramView.findViewById(2131305134));
      this.tvy = paramView.findViewById(2131300518);
      this.tvz = paramView.findViewById(2131302790);
      this.tvA = paramView.findViewById(2131301490);
      this.tvs.setOnLongClickListener(c.e(c.this));
      this.tvs.setOnClickListener(c.e(c.this));
      this.fBA.setOnLongClickListener(c.e(c.this));
      this.fBA.setOnClickListener(c.e(c.this));
      this.nMU.setOnLongClickListener(c.e(c.this));
      this.nMU.setOnClickListener(c.e(c.this));
      AppMethodBeat.o(183886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.c
 * JD-Core Version:    0.7.0.1
 */