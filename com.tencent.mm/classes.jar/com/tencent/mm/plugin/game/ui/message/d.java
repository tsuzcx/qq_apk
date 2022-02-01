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

public final class d
  extends RecyclerView
{
  private int fsv;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> skT;
  b snI;
  private e snw;
  private Set<Integer> snx;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183896);
    this.snx = new HashSet();
    this.mContext = paramContext;
    this.fsv = paramInt;
    this.skT = new b(30, getClass());
    this.snw = new e(this.fsv, new e.b()
    {
      public final void cEs()
      {
        AppMethodBeat.i(183891);
        d.a(d.this).dbk = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().EB(2);
        Cursor localCursor = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().Ez(2);
        d.a(d.this).changeCursor(localCursor);
        AppMethodBeat.o(183891);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().EB(2);
    this.snI = new b(paramContext, ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().Ez(2), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.snI);
    AppMethodBeat.o(183896);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183897);
    e.a.a locala = new e.a.a();
    locala.hjS = false;
    locala.soG = paramFloat;
    com.tencent.mm.plugin.game.f.e.cEB().a(paramImageView, paramString, locala.cEC(), new com.tencent.mm.plugin.game.f.e.b()
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
    extends RecyclerView.v
  {
    ImageView fxT;
    TextView lEA;
    TextView nkb;
    View snF;
    View snG;
    View snH;
    private ViewGroup snK;
    ImageView snL;
    ViewGroup snz;
    TextView timeTv;
    TextView titleTv;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(183893);
      this.snz = ((ViewGroup)paramView.findViewById(2131302521));
      this.fxT = ((ImageView)paramView.findViewById(2131300891));
      this.nkb = ((TextView)paramView.findViewById(2131302867));
      this.snK = ((ViewGroup)paramView.findViewById(2131302522));
      this.snL = ((ImageView)paramView.findViewById(2131297877));
      this.titleTv = ((TextView)paramView.findViewById(2131297914));
      this.lEA = ((TextView)paramView.findViewById(2131297777));
      this.timeTv = ((TextView)paramView.findViewById(2131305822));
      this.snF = paramView.findViewById(2131300518);
      this.snG = paramView.findViewById(2131302790);
      this.snH = paramView.findViewById(2131301490);
      this.snz.setOnLongClickListener(d.e(d.this));
      this.snz.setOnClickListener(d.e(d.this));
      this.fxT.setOnLongClickListener(d.e(d.this));
      this.fxT.setOnClickListener(d.e(d.this));
      this.nkb.setOnLongClickListener(d.e(d.this));
      this.nkb.setOnClickListener(d.e(d.this));
      AppMethodBeat.o(183893);
    }
  }
  
  final class b
    extends f<d.a>
  {
    int dbk;
    
    public b(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.dbk = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.d
 * JD-Core Version:    0.7.0.1
 */