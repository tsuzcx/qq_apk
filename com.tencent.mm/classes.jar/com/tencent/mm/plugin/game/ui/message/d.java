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

public final class d
  extends RecyclerView
{
  private int fwc;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> tsM;
  b tvB;
  private e tvp;
  private Set<Integer> tvq;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183896);
    this.tvq = new HashSet();
    this.mContext = paramContext;
    this.fwc = paramInt;
    this.tsM = new b(30, getClass());
    this.tvp = new e(this.fwc, new e.b()
    {
      public final void cRC()
      {
        AppMethodBeat.i(183891);
        d.a(d.this).cYG = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gx(2);
        Cursor localCursor = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gv(2);
        d.a(d.this).changeCursor(localCursor);
        AppMethodBeat.o(183891);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gx(2);
    this.tvB = new b(paramContext, ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gv(2), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.tvB);
    AppMethodBeat.o(183896);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183897);
    e.a.a locala = new e.a.a();
    locala.hKv = false;
    locala.twz = paramFloat;
    com.tencent.mm.plugin.game.f.e.cRL().a(paramImageView, paramString, locala.cRM(), new com.tencent.mm.plugin.game.f.e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(183892);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          d.f(d.this).put(paramString, paramAnonymousBitmap);
        }
        AppMethodBeat.o(183892);
      }
    });
    AppMethodBeat.o(183897);
  }
  
  final class a
    extends RecyclerView.w
  {
    ImageView fBA;
    TextView gAI;
    TextView nMU;
    TextView timeTv;
    TextView titleTv;
    View tvA;
    private ViewGroup tvD;
    ImageView tvE;
    ViewGroup tvs;
    View tvy;
    View tvz;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(183893);
      this.tvs = ((ViewGroup)paramView.findViewById(2131302521));
      this.fBA = ((ImageView)paramView.findViewById(2131300891));
      this.nMU = ((TextView)paramView.findViewById(2131302867));
      this.tvD = ((ViewGroup)paramView.findViewById(2131302522));
      this.tvE = ((ImageView)paramView.findViewById(2131297877));
      this.titleTv = ((TextView)paramView.findViewById(2131297914));
      this.gAI = ((TextView)paramView.findViewById(2131297777));
      this.timeTv = ((TextView)paramView.findViewById(2131305822));
      this.tvy = paramView.findViewById(2131300518);
      this.tvz = paramView.findViewById(2131302790);
      this.tvA = paramView.findViewById(2131301490);
      this.tvs.setOnLongClickListener(d.e(d.this));
      this.tvs.setOnClickListener(d.e(d.this));
      this.fBA.setOnLongClickListener(d.e(d.this));
      this.fBA.setOnClickListener(d.e(d.this));
      this.nMU.setOnLongClickListener(d.e(d.this));
      this.nMU.setOnClickListener(d.e(d.this));
      AppMethodBeat.o(183893);
    }
  }
  
  final class b
    extends f<d.a>
  {
    int cYG;
    
    public b(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.cYG = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.d
 * JD-Core Version:    0.7.0.1
 */