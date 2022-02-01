package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
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
  private int fsv;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> skT;
  a snv;
  private e snw;
  private Set<Integer> snx;
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183887);
    this.snx = new HashSet();
    this.mContext = paramContext;
    this.fsv = paramInt;
    this.skT = new b(30, getClass());
    this.snw = new e(this.fsv, new e.b()
    {
      public final void cEs()
      {
        AppMethodBeat.i(183882);
        c.a(c.this).dbk = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().EB(2);
        Cursor localCursor = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().Ez(1);
        c.a(c.this).changeCursor(localCursor);
        AppMethodBeat.o(183882);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().EB(1);
    this.snv = new a(paramContext, ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().Ez(1), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.snv);
    AppMethodBeat.o(183887);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183888);
    e.a.a locala = new e.a.a();
    locala.hjS = false;
    locala.soG = paramFloat;
    com.tencent.mm.plugin.game.f.e.cEB().a(paramImageView, paramString, locala.cEC(), new com.tencent.mm.plugin.game.f.e.b()
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
    int dbk;
    
    public a(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.dbk = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    ImageView fxT;
    TextView nkb;
    TextView snA;
    TextView snB;
    ImageView snC;
    TextView snD;
    TextView snE;
    View snF;
    View snG;
    View snH;
    ViewGroup snz;
    TextView timeTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(183886);
      this.snz = ((ViewGroup)paramView.findViewById(2131302521));
      this.fxT = ((ImageView)paramView.findViewById(2131300891));
      this.nkb = ((TextView)paramView.findViewById(2131302867));
      this.snA = ((TextView)paramView.findViewById(2131302485));
      this.snB = ((TextView)paramView.findViewById(2131304199));
      this.snC = ((ImageView)paramView.findViewById(2131304189));
      this.snD = ((TextView)paramView.findViewById(2131298778));
      this.timeTv = ((TextView)paramView.findViewById(2131305822));
      this.snE = ((TextView)paramView.findViewById(2131305134));
      this.snF = paramView.findViewById(2131300518);
      this.snG = paramView.findViewById(2131302790);
      this.snH = paramView.findViewById(2131301490);
      this.snz.setOnLongClickListener(c.e(c.this));
      this.snz.setOnClickListener(c.e(c.this));
      this.fxT.setOnLongClickListener(c.e(c.this));
      this.fxT.setOnClickListener(c.e(c.this));
      this.nkb.setOnLongClickListener(c.e(c.this));
      this.nkb.setOnClickListener(c.e(c.this));
      AppMethodBeat.o(183886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.c
 * JD-Core Version:    0.7.0.1
 */