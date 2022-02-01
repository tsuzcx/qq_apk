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
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.game.e.e.a.a;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashSet;
import java.util.Set;

public final class e
  extends RecyclerView
{
  private int gwE;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> xUC;
  b xYB;
  private f xYo;
  private c xYp;
  private Set<Integer> xYq;
  
  public e(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183896);
    this.xYq = new HashSet();
    this.mContext = paramContext;
    this.gwE = paramInt;
    this.xUC = new b(30, getClass());
    this.xYo = new f(this.gwE, new f.b()
    {
      public final void dWI()
      {
        AppMethodBeat.i(183891);
        e.a(e.this);
        AppMethodBeat.o(183891);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(2);
    this.xYB = new b(paramContext, ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().On(2), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.xYB);
    AppMethodBeat.o(183896);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183897);
    e.a.a locala = new e.a.a();
    locala.jbd = false;
    locala.xZw = paramFloat;
    com.tencent.mm.plugin.game.e.e.dWR().a(paramImageView, paramString, locala.dWS(), new com.tencent.mm.plugin.game.e.e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(183892);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          e.f(e.this).put(paramString, paramAnonymousBitmap);
        }
        AppMethodBeat.o(183892);
      }
    });
    AppMethodBeat.o(183897);
  }
  
  public final void setEmptyCallback(c paramc)
  {
    this.xYp = paramc;
  }
  
  final class a
    extends RecyclerView.v
  {
    ImageView gBZ;
    TextView hPW;
    TextView pIN;
    TextView timeTv;
    TextView titleTv;
    View xYA;
    private ViewGroup xYD;
    ImageView xYE;
    ViewGroup xYs;
    View xYy;
    View xYz;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(183893);
      this.xYs = ((ViewGroup)paramView.findViewById(2131304950));
      this.gBZ = ((ImageView)paramView.findViewById(2131302497));
      this.pIN = ((TextView)paramView.findViewById(2131305440));
      this.xYD = ((ViewGroup)paramView.findViewById(2131304951));
      this.xYE = ((ImageView)paramView.findViewById(2131298194));
      this.titleTv = ((TextView)paramView.findViewById(2131298232));
      this.hPW = ((TextView)paramView.findViewById(2131298092));
      this.timeTv = ((TextView)paramView.findViewById(2131309101));
      this.xYy = paramView.findViewById(2131302045);
      this.xYz = paramView.findViewById(2131305359);
      this.xYA = paramView.findViewById(2131303689);
      this.xYs.setOnLongClickListener(e.e(e.this));
      this.xYs.setOnClickListener(e.e(e.this));
      this.gBZ.setOnLongClickListener(e.e(e.this));
      this.gBZ.setOnClickListener(e.e(e.this));
      this.pIN.setOnLongClickListener(e.e(e.this));
      this.pIN.setOnClickListener(e.e(e.this));
      AppMethodBeat.o(183893);
    }
  }
  
  final class b
    extends g<e.a>
  {
    int dCm;
    
    public b(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.dCm = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.e
 * JD-Core Version:    0.7.0.1
 */